package com.tydino.everbloomdandaloo.client.entities.aether.manticore;

import com.tydino.everbloomdandaloo.client.entities.aether.manticore.ManticoreRenderState;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ManticoreModel extends EntityModel<ManticoreRenderState> {
	private final ModelPart root;
	private final ModelPart butt;
	private final ModelPart chest;
	private final ModelPart head;
	private final ModelPart mane;
	private final ModelPart jaw;
	private final ModelPart leftear;
	private final ModelPart rightear;
	private final ModelPart eyelids;
	private final ModelPart leftwingbase;
	private final ModelPart leftwingtip;
	private final ModelPart rightwingbase;
	private final ModelPart rightwingtip;
	private final ModelPart tailbase;
	private final ModelPart tailmid1;
	private final ModelPart tailmid2;
	private final ModelPart tailtip;
	private final ModelPart backleftfoot;
	private final ModelPart backleftcalf;
	private final ModelPart backleftknee;
	private final ModelPart backleftthigh;
	private final ModelPart backrightfoot;
	private final ModelPart backrightcalf;
	private final ModelPart backrightknee;
	private final ModelPart backrightthigh;
	private final ModelPart frontleftfoot;
	private final ModelPart frontleftcalf;
	private final ModelPart frontleftthigh;
	private final ModelPart frontrightfoot;
	private final ModelPart frontrightcalf;
	private final ModelPart frontrightthigh;

	final KeyframeAnimation idle;
	final KeyframeAnimation blink;
	final KeyframeAnimation walk;
	final KeyframeAnimation attack;
	final KeyframeAnimation flying;

	public ManticoreModel(ModelPart root) {
		super(root);
		this.root = root.getChild("root");
		this.butt = this.root.getChild("butt");
		this.chest = this.butt.getChild("chest");
		this.head = this.chest.getChild("head");
		this.mane = this.head.getChild("mane");
		this.jaw = this.head.getChild("jaw");
		this.leftear = this.head.getChild("leftear");
		this.rightear = this.head.getChild("rightear");
		this.eyelids = this.head.getChild("eyelids");
		this.leftwingbase = this.chest.getChild("leftwingbase");
		this.leftwingtip = this.leftwingbase.getChild("leftwingtip");
		this.rightwingbase = this.chest.getChild("rightwingbase");
		this.rightwingtip = this.rightwingbase.getChild("rightwingtip");
		this.tailbase = this.butt.getChild("tailbase");
		this.tailmid1 = this.tailbase.getChild("tailmid1");
		this.tailmid2 = this.tailmid1.getChild("tailmid2");
		this.tailtip = this.tailmid2.getChild("tailtip");
		this.backleftfoot = this.root.getChild("backleftfoot");
		this.backleftcalf = this.backleftfoot.getChild("backleftcalf");
		this.backleftknee = this.backleftcalf.getChild("backleftknee");
		this.backleftthigh = this.backleftknee.getChild("backleftthigh");
		this.backrightfoot = this.root.getChild("backrightfoot");
		this.backrightcalf = this.backrightfoot.getChild("backrightcalf");
		this.backrightknee = this.backrightcalf.getChild("backrightknee");
		this.backrightthigh = this.backrightknee.getChild("backrightthigh");
		this.frontleftfoot = this.root.getChild("frontleftfoot");
		this.frontleftcalf = this.frontleftfoot.getChild("frontleftcalf");
		this.frontleftthigh = this.frontleftcalf.getChild("frontleftthigh");
		this.frontrightfoot = this.root.getChild("frontrightfoot");
		this.frontrightcalf = this.frontrightfoot.getChild("frontrightcalf");
		this.frontrightthigh = this.frontrightcalf.getChild("frontrightthigh");

		this.walk = ManticoreAnimations.walking.bake(root);
		this.idle = ManticoreAnimations.idle.bake(root);
		this.blink = ManticoreAnimations.blinking.bake(root);
		this.attack = ManticoreAnimations.attack.bake(root);
		this.flying = ManticoreAnimations.flying.bake(root);
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition root = modelPartData.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 8.0F));

		PartDefinition butt = root.addOrReplaceChild("butt", CubeListBuilder.create().texOffs(15, 0).addBox(-3.0F, -2.0F, -7.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition chest = butt.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(16, 12).addBox(-3.5F, -4.0F, -8.0F, 7.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -8.0F));

		PartDefinition head = chest.addOrReplaceChild("head", CubeListBuilder.create().texOffs(41, 31).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -7.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(50, 42).addBox(-2.5F, -1.5F, -1.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, -6.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition mane = head.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(12, 30).addBox(-4.5F, -5.0F, -3.0F, 9.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(39, 42).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(40, 32).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, -2.0F, 0.1745F, 0.0F, 0.5236F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(58, 32).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, -2.0F, 0.1745F, 0.0F, -0.5236F));

		PartDefinition eyelids = head.addOrReplaceChild("eyelids", CubeListBuilder.create().texOffs(44, 31).addBox(1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(58, 31).addBox(-2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -5.01F));

		PartDefinition leftwingbase = chest.addOrReplaceChild("leftwingbase", CubeListBuilder.create().texOffs(0, 47).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 41).addBox(0.0F, -11.0F, 1.0F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.0F, -3.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition leftwingtip = leftwingbase.addOrReplaceChild("leftwingtip", CubeListBuilder.create().texOffs(8, 47).addBox(-0.5F, -13.0F, -0.5F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 54).addBox(0.0F, -13.0F, 0.0F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.0F, 0.0F, 2.5307F));

		PartDefinition rightwingbase = chest.addOrReplaceChild("rightwingbase", CubeListBuilder.create().texOffs(28, 45).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 41).addBox(0.0F, -11.0F, 1.0F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.0F, -3.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition rightwingtip = rightwingbase.addOrReplaceChild("rightwingtip", CubeListBuilder.create().texOffs(36, 45).addBox(-0.5F, -13.0F, -0.5F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 54).addBox(0.0F, -13.0F, 0.0F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.0F, 0.0F, -2.5307F));

		PartDefinition tailbase = butt.addOrReplaceChild("tailbase", CubeListBuilder.create().texOffs(12, 45).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition tailmid1 = tailbase.addOrReplaceChild("tailmid1", CubeListBuilder.create().texOffs(12, 53).addBox(-1.5F, -1.5F, 1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition tailmid2 = tailmid1.addOrReplaceChild("tailmid2", CubeListBuilder.create().texOffs(14, 59).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition tailtip = tailmid2.addOrReplaceChild("tailtip", CubeListBuilder.create().texOffs(14, 63).addBox(-1.5F, -3.0F, 1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(21, 51).addBox(0.0F, -5.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 2.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition backleftfoot = root.addOrReplaceChild("backleftfoot", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, -1.0F));

		PartDefinition backleftcalf = backleftfoot.addOrReplaceChild("backleftcalf", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition backleftknee = backleftcalf.addOrReplaceChild("backleftknee", CubeListBuilder.create().texOffs(5, 8).addBox(-0.85F, -5.5F, -2.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition backleftthigh = backleftknee.addOrReplaceChild("backleftthigh", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -10.0F, -1.0F, 3.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition backrightfoot = root.addOrReplaceChild("backrightfoot", CubeListBuilder.create().texOffs(42, 0).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, -1.0F));

		PartDefinition backrightcalf = backrightfoot.addOrReplaceChild("backrightcalf", CubeListBuilder.create().texOffs(48, 5).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition backrightknee = backrightcalf.addOrReplaceChild("backrightknee", CubeListBuilder.create().texOffs(48, 11).addBox(-1.15F, -5.5F, -2.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition backrightthigh = backrightknee.addOrReplaceChild("backrightthigh", CubeListBuilder.create().texOffs(53, 15).addBox(-2.0F, -10.0F, -1.0F, 3.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition frontleftfoot = root.addOrReplaceChild("frontleftfoot", CubeListBuilder.create().texOffs(12, 3).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, -12.0F));

		PartDefinition frontleftcalf = frontleftfoot.addOrReplaceChild("frontleftcalf", CubeListBuilder.create().texOffs(18, 15).addBox(-1.15F, -4.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition frontleftthigh = frontleftcalf.addOrReplaceChild("frontleftthigh", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -11.0F, -1.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition frontrightfoot = root.addOrReplaceChild("frontrightfoot", CubeListBuilder.create().texOffs(34, 3).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, -12.0F));

		PartDefinition frontrightcalf = frontrightfoot.addOrReplaceChild("frontrightcalf", CubeListBuilder.create().texOffs(40, 15).addBox(-0.85F, -4.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition frontrightthigh = frontrightcalf.addOrReplaceChild("frontrightthigh", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -11.0F, -1.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
		return LayerDefinition.create(modelData, 69, 74);
	}

	@Override
	public void setupAnim(ManticoreRenderState state) {
		super.setupAnim(state);

		if(state.blinkAnimation.isStarted()){
			this.blink.apply(state.blinkAnimation, state.ageInTicks);
		}

		if(state.idleAnimation.isStarted()){
			this.idle.apply(state.idleAnimation, state.ageInTicks);
		}

		if(state.attackAnimation.isStarted()){
			this.attack.apply(state.attackAnimation, state.ageInTicks);
		}

		if(state.flyingAniamtion.isStarted()){
			this.flying.apply(state.flyingAniamtion, state.ageInTicks);
		}

		this.walk.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);/// animation step / distance entity speed

		this.head.xRot = state.xRot * (float) (Math.PI / 180.0);
		this.head.yRot = state.yRot * (float) (Math.PI / 180.0);
	}
}